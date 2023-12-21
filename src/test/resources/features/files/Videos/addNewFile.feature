@PlusButton
Feature: Add files from the "Videos" folder

Background:
Given that the user is unlocked in the Tella app
And is within the "Videos" folder
And there are video files in the "Videos" folder

@Smoke @VideosFolder @CaptureFile 
Scenario Outline: Capture a file of type <type> from the "Videos" folder
When the user taps the "+" button
And selects the option "Take photo/video"
And selects the option <option>
And captures the file of type <type>
Then the message "file encrypted" appears
And the file of type <type> is saved correctly in the folder <folder>
And the file of type <type> appears in the list of files in the folder <folder>

  Examples:
  | type   | folder   | option |
  | image  | Images   | Photo  |
  | video  | Videos   | Video  |

@Smoke @VideosFolder @CaptureFile
Scenario: Record audio from the "Videos" folder
When the user taps the "+" button
And selects the option "Record audio"
And captures the audio
Then the message "The audio recording was saved to your Tella files" appears
And the audio file is saved correctly in the "Audios" folder
And the audio file appears in the list of files in the "Audios" folder

@Smoke @VideosFolder @ImportFile
Scenario: Import a file of type video from the "Videos" folder preserving the original
When the user taps the "+" button
And selects the option "Import from device"
And taps the "KEEP ORIGINAL" button
And taps the "Continue" button
And selects a file of type video from the device
Then the file is saved in the folder "Videos"
And the file of type video appears in the list of files in the folder "Videos"
 
@Smoke @VideosFolder @ImportFile
Scenario: Import a file of type video from the "Videos" folder, deleting the original
When the user taps the "+" button
And selects the option "Import from device"
And taps the "DELETE ORIGINAL" button
And taps the "Continue" button
And selects a file of type "video.mp4" from the device
Then the file is saved in the folder "Videos"
And the file of type "video.mp4"  appears in the list of files in the folder "Videos"
And the original file is deleted from the device
  
@Regression @VideosFolder @ImportFile
Scenario: Import a duplicate file of type video from the "Videos" folder
When the user taps the "+" button
And selects the option "Import from device"
And taps the "KEEP ORIGINAL" button
And taps the "Continue" button
And selects a file of type "video.mp4" from the device
And taps the "+" button again
And selects the option "Import from device"
And taps the "KEEP ORIGINAL" button
And taps the "Continue" button
And selects the same file of type "video.mp4" from the device
Then the duplicate file is imported correctly with a different name
And the file of type "video.mp4" appears in the list of files in the "Videos" folder