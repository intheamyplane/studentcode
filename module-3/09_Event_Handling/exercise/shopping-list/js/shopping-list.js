let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

function toggleAll(items) {
  const toggleAllButton = document.getElementById('toggleAll');
  items.forEach((item) =>{
  if (allItemsIncomplete){
    
      item.classList.add('completed');
      item.querySelector('i').classList.add('completed');
      
    }else {
      item.classList.remove('completed');
      item.querySelector('i').classList.remove('completed');
    
  
    }
  });
  allItemsIncomplete = !allItemsIncomplete; 
  changeGreeting(toggleAllButton);

}



  function changeGreeting(button) {
    if (allItemsIncomplete) {
      button.innerText = "Mark All Complete";
    } else {
      button.innerText = "Mark All Incomplete";
    }
}

document.addEventListener("DOMContentLoaded", () => {
  setPageTitle();
  displayGroceries();

  const listItems = document.querySelectorAll('li');

  listItems.forEach((listItem) => {
    //click to mark complete
    listItem.addEventListener('click', () => {
      if(!listItem.classList.contains('completed')) {
        listItem.classList.add('completed');
        listItem.querySelector('i').classList.add('completed');
      }
    });

    //double click to removed completed class
    listItem.addEventListener('dblclick', () => {
      if(listItem.classList.contains('completed')) {
        listItem.classList.remove('completed');
        listItem.querySelector('i').classList.remove('completed');
      }
    });
  
  });


  //mark all tasks completed
  const toggleAllButton = document.getElementById('toggleAll');

  toggleAllButton.addEventListener('click', () => {
   toggleAll(listItems);
  });


// const changeButton = document.getElementById('change-greeting');
// changeButton.addEventListener('click', changeGreeting);
});


