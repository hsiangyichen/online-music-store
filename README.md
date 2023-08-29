# My Personal Project of CPSC 210

**Student Name :** Hsiang Yi Chen

**Student Number :** 65406415

## A Delivery Service of many Stores

My Bulleted List :
- What will the application do?  
- Who will use it?
- Why is this project of interest to you?

#### *Design Decisions*
  > *What will the application do?*

This application is an online music store which contains users, different songs, and a shopping cart. It is a system 
that can help users add or remove songs on the shopping cart; and it will print out a receipt clearly listing every 
song, its unit price, and add up the total expenditure of a user. In more detail, their will be a student discount 
plan which can have a discount of 10% off for a student.

   > *Who will use it?*

Those who prefer listen legal-copy of the music instead of pirated copies of music. Although it cost money to buy
songs in the application, there is no doubt that the quality of the songs and the function of the application are both
much better than those which are free.

   > *Why is this project of interest to you?*

I am a person who love to listen to different songs.  It is really a good idea to listen musics which do not have to 
connect the internet and download it easily to a playlist which contains a clear layout and interface.


#### *User Stories*
<ol>
<li>As a user, I want to be able to add a new song to my shopping cart</li>
<li>As a user, I want to be able to view the list of my shopping cart</li>
<li>As a user, I want to be able to delete a song from my shopping cart</li>
<li>As a user, I want to be able to check if I am available to get a discount of the order</li>
<li>As a user, I want to be able to see the total spend on an order from a digital receipt</li>
<li>As a user, when I select the save option from the application menu, I want to be able to save my 
cart list to the file</li>
<li>As a user, when I start the application, I want to be given the option to load my cart list from file.</li>
</ol>

#### *Phase 4: Task 2*
I chose the second option which is a type hierarchy. The parent class is Tool which includes the component of GUI like frame, buttons, or labels.
There are 7 subclasses as shown below. They are separated by different functions such as add, remove, save, load, and print;
and the other 2 are the main window and the menu window.
<ol>
<li>AddTool: Add songs to the cart.</li>
<li>RemoveTool: Remove songs to the cart.</li>
<li>SaveTool: Save songs to the cart.</li>
<li>LoadTool: Load songs to the cart.</li>
<li>PrintCartTool: Print the receipt.</li>
<li>MainWindow: The first web page.</li>
<li>MenuWindow: The menu of the application.</li>
</ol>

#### *Phase 4: Task 3*
   > *Reflection on My Design*
    
Firstly, in order to have the same size of frame and the same location of some labels and buttons, I made a parent class 
to include all the similar method I want to use in my subclasses (windows). There are 7 subclasses that I just mentioned 
on the last part which represent different functionality. Moreover, due to the reason that there is only one shopping cart
for each user, I add a shopping cart as a parameter in my parent class so that 
it can be used by all the subclasses. In addition, my ShoppingCart class includes a list of songs that
the user can add many songs in it. 

   > *How will I refactor my application?*

The thing that I want to refactor is to avoid some duplicated lines in methods in AddTool and RemoveTool class. For example,
in the AddTool class there are two methods called addSuccessfully(); and unAddSuccessfully(); which almost have the same
lines excluding the different title of the label, so as the RemoveTool class.


    