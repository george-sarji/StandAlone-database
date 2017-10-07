# StandAlone-database
Work for school on a standalone database for android.

## Update 23/SEP/2017:
Added the Database Manager and the Database Tool, along with the access database. The database has been initialized with the AddTask function inside the DatabaseManager class in order to add a task.
Check AddTask for the two different variants of the addition of the task into the database.
Only work was done inside the DatabaseManager class. Review class in case of errors.

## Update 25/SEP/2017:
Began adding tasks, deleting tasks and showing all tasks that are in the database. Added an inner class inside the DatabaseManager named DatabaseTool. Code is 95% finished.

## Update 29/SEP/2017 - 08:45:
Began working on the view all tasks again; ran into a problem, which is the table spacing. Need to google further for the solution to create dynamic table margins. The table for show all tasks is complete and ready for use, added a scrollable view so that the user ca use it with multiple tasks.
To do: Create the function to edit a specific task. Keep in mind the task object is set in the button's tag. 

## Update 30/SEP/2017 - 10:15:
Finished the layout properly while editing the width for the fields inside the MainActivity. Need to build the EditTask functions, check the notes inside the class for reference.
Needs to be done by the 31st of September, 2017, 20:00.

## Update 1/OCT/2017 + 02/OCT/2017 - 07:35:
Finished the update task with no testing; work done in EditTask.java and activity_edittask.xml. Review changes and test on phone for finalization of the operation. Create the delete task activity and add checkboxes to mark tasks as done in the show tasks page (MainAcitivity). Finish by the 5th of October.
 
## Update 07/OCT/2017 - 8:45:
Finished the EditTask activity with the coding along with testing. Need to check how to change default selected item in a spinner list for the priority, along with adding a radio group to set the done parameter in the task.

## Update 07/OCT/2017 - 9:30:
Re-did the edit task activity, added taking a photo in the add task activity, need to add a preview of the image in the edit task activity. Also added the checkbox for the done in the edit task and added the spinner selection to be on the correct priority in edit task. Need to work on decoding the byte array to a Bitmap to add to ImageView in the edittask activity.