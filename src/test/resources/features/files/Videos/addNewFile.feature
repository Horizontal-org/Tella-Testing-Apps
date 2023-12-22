Feature: Add files from the "Videos" folder

Background:
Given that the user is unlocked in the Tella app
And is within the "Videos" folder

@Smoke 
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

@Smoke 
Scenario: Record audio from the "Videos" folder
When the user taps the "+" button
And selects the option "Record audio"
And captures the audio
Then the message "The audio recording was saved to your Tella files" appears
And the audio file is saved correctly in the "Audios" folder
And the audio file appears in the list of files in the "Audios" folder

@Smoke @Regression
Scenario Outline: Import a file of type <type> from the "Videos" folder preserving the original
When the user taps the "+" button
And selects the option "Import from device"
And taps the "KEEP ORIGINAL" button
And taps the "Continue" button
And selects a file of type <type> from the device
Then the file is saved in the folder <folder>
And the file of type <type> appears in the list of files in the folder <folder>

Examples:
  | type           | folder      |
  | image.jpg      | Images      |
  | image.png      | Images      |
  | video.mp4      | Videos      |
  | video.mov      | Videos      |
  | audio.mp3      | Audios      |
  | audio.aac      | Audios      |
  | document.pdf   | Documents   |
  | document.docx  | Documents   |

@Smoke @Regression
Scenario Outline: Import a file of type <type> from the "Videos" folder, deleting the original
When the user taps the "+" button
And selects the option "Import from device"
And taps the "DELETE ORIGINAL" button
And taps the "Continue" button
And selects a file of type <type> from the device
Then the file is saved in the folder <folder>
And the file of type <type> appears in the list of files in the folder <folder>
And the original file is deleted from the device

Examples:
  | type           | folder      |
  | image.jpg      | Images      |
  | image.png      | Images      |
  | video.mp4      | Videos      |
  | video.mov      | Videos      |
  | audio.mp3      | Audios      |
  | audio.aac      | Audios      |
  | document.pdf   | Documents   |
  | document.docx  | Documents   |

@Smoke @Regression
Scenario Outline: Import a duplicate file of type <type> from the "Videos" folder
When the user taps the "+" button
And selects the option "Import from device"
And taps the "KEEP ORIGINAL" button
And taps the "Continue" button
And selects a file of type <type> from the device
And taps the "+" button again
And selects the option "Import from device"
And taps the "KEEP ORIGINAL" button
And taps the "Continue" button
And selects a file of type <type> from the device
Then the duplicate file is imported correctly with a different name
And the file of type <type> appears in the list of files in the folder <folder>

Examples:
  | type       | folder     |
  | image.jpg  | Images     |
  | video.MP4  | Videos     |
  | audio.aac  | Audios     |
  | doc.PDF    | Documents  |
