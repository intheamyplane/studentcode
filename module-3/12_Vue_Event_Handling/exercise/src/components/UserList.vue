<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" v-model='selectAll' v-bind:checked='selectedUsers.length === users.length ? selectAll = true : selectAll = false' v-on:change='pushSelectedUsers' id="selectAll" />
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input type="checkbox" name= "selectUser" v-model="selectedUsers" v-bind:id="user.id" v-bind:value="user.id" />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button v-on:click="toggleStatus(user.id)" class="btnActivateDeactivate">{{buttonText(user.status)}}</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button v-bind:disabled="selectedUsers.length==0" v-on:click='activateUsers' >Activate Users</button>
      <button v-bind:disabled="selectedUsers.length==0" v-on:click='deactivateUsers'>Deactivate Users</button>
      <button v-bind:disabled="selectedUsers.length==0" v-on:click='deleteUsers'>Delete Users</button>
    </div>

    <button v-on:click="toggleNewUser">Add New User</button>

    <form v-show="showForm" v-on:submit.prevent="addUser" id="frmAddNewUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input v-model="newUser.firstName" type="text" name="firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input v-model="newUser.lastName" type="text" name="lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input v-model="newUser.username" type="text" name="username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input v-model="newUser.emailAddress" type="text" name="emailAddress" />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      selectedUsers: [],
      selectAll: false,
    
      showForm: false,
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      nextUserId: 7,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive"
        }
      ]
    };
  },
  methods: {
    pushSelectedUsers(){
      if(this.selectAll){
        this.selectedUsers = [];
        this.users.forEach((user) =>{
          this.selectedUsers.push(user.id)
        });
      }else{
        this.selectedUsers = [];
      }
    },
    getNextUserId() {
      return this.nextUserId++;
    },
    addUser() {
      this.newUser.id = this.getNextUserId();
      this.users.push(this.newUser);
      this.clearForm();
    },

    deleteUsers(){
      this.selectedUsers.forEach((userId) => {
        let deleted = this.users.find((user) => 
          user.id === userId);
        this.users.splice(this.users.indexOf(deleted), 1);
      })
      this.selectUser= false;
      this.selectedUsers= [];
      
    },

    clearForm() {
      this.newUser= {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
        }
    },

    selectedUsersAvailable(){
      if(this.selectedUsers.length > 0){
        return true;
      }
    },

    selectUser(){
      this.selectedUsers.push({
        id: this.user.id,
        firstName: this.user.firstName,
        lastName: this.user.lastName,
        username: this.user.username,
        emailAddress: this.user.emailAddress,
        status: this.user.status

      });
      
    },

    toggleNewUser(){
      this.showForm = !this.showForm
    },
    toggleStatus(id) {
      for (let i = 0; i < this.users.length; i++) {
        if(id == this.users[i].id){
          if(this.users[i].status == 'Active'){
            this.users[i].status = 'Inactive'
          } else if (this.users[i].status == 'Inactive'){
            this.users[i].status = 'Active' 
          }
        }
      }
    },
    buttonText(status){
      let btnText = ""
      if(status == 'Active'){
        btnText = "Deactivate"
      }else if (status == 'Inactive'){
        btnText = 'Activate'
      }

      return btnText
    },
    activateUsers(){
    this.selectedUsers.forEach((userId)=>{
      let userToActivate = this.users.find(user => user.id == userId);
      userToActivate.status = 'Active';
      
    });
    this.selectedUsers = [];

    },

    deactivateUsers(){
      this.selectedUsers.forEach((userId)=>{
        let userToDelete = this.users.find(user => user.id == userId)
        userToDelete.status = 'Inactive';
      });
      this.selectedUsers= [];
    },

  },


  computed: {
 
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    }
  }
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
