// add pageTitle

const titleName = 'My Shopping List';
// add groceries

const groceries = ["beef", "milk", "apples", "ginger", "garlic", "oil", "onions", "carrots", "sugar", "flour"];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('title');
  pageTitle.innerText = titleName;

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const groceryList = document.getElementById('groceries');
  for(let i = 0; i<groceries.length; i++){
    const listItem = document.createElement('li');
    listItem.innerText= groceries[i];
    groceryList.appendChild(listItem);
  }

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item add the class completed to each one
 */
function markCompleted() {
  const groceryList = document.querySelectorAll('#groceries>li');
  groceryList.forEach( (listItem) => {
    listItem.classList.add('completed');
  });


}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
