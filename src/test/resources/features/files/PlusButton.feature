@PlusButton
Feature: Plus button

  Background:
    Given the user is in Tella home page

  @Smoke @Automated @CaptureFile
  Scenario Outline: Capture a file of type <type> from folder <folder>
    When the user enters the folder <folder>
    And taps the "+" button
    And selects the option: "Take photovideo"
    And selects the option <option>
    And captures the file of type <type>
    Then the message <expectedMessage> appears
    And the file of type <type> is saved correctly in the folder <folderSave>
    And the file appears in the list of files in the folder <folderSave>
    Then the file appears in the "All files" folder

    Examples:
      | type  | folderSave | option | folder    | expectedMessage |
      | image | Images     | Photo  | All files | File encrypted  |
      | video | Videos     | Video  | All files | File encrypted  |
      | image | Images     | Photo  | Documents | File encrypted  |
      | video | Videos     | Video  | Documents | File encrypted  |
      | image | Images     | Photo  | Images    | File encrypted  |
      | video | Videos     | Video  | Images    | File encrypted  |
      | image | Images     | Photo  | Audio     | File encrypted  |
      | video | Videos     | Video  | Audio     | File encrypted  |
      | image | Images     | Photo  | Videos    | File encrypted  |
      | video | Videos     | Video  | Videos    | File encrypted  |
      | image | Images     | Photo  | Others    | File encrypted  |
      | video | Videos     | Video  | Others    | File encrypted  |

  @Smoke
  Scenario Outline: Record an audio file from the folder <folder>
    When the user enters the folder <folder>
    And taps the "+" button
    And selects the option "Record audio"
    And captures the audio
    Then the message "The audio recording was saved to your Tella files" appears
    And the audio file is saved correctly in the "Audio" folder
    And the audio file appears in the list of files in the "Audio" folder
    And the audio file appears in the list of files in the "All files" folder

    Examples:
      | folder    |
      | All files |
      | Documents |
      | Images    |
      | Audio     |
      | Video     |
      | Others    |

  @Smoke
  Scenario Outline: Import a file of type <type> from a folder <folder> - preserving the original
    When the user enters the folder <folder>
    And taps the "+" button
    And selects the option "Import from device"
    And taps the "KEEP ORIGINAL" button
    And taps the "Continue" button
    And selects a file of type <type> from the device
    Then the file is saved in the folder <folderSave>
    And the file of type <type> appears in the list of files in the folder <folderSave>
    And the file appears in the "All files" folder

    Examples:
      | type     | folderSave | folder    |
      | image    | Images     | All files |
      | video    | Videos     | All files |
      | audio    | Audios     | All files |
      | document | Documents  | All files |
      | document | Documents  | Documents |
      | image    | Images     | Images    |
      | audio    | Audios     | Audio     |

  @Regression
  Scenario Outline: Import a file of type <type> from a folder <folder> - deleting the original
    When the user enters the folder <folder>
    And taps the "+" button
    And selects the option "Import from device"
    And taps the "DELETE ORIGINAL" button
    And taps the "Continue" button
    And selects a file of type <type> from the device
    Then the file is saved in the folder <folderSave>
    And the file of type <type> appears in the list of files in the folder <folderSave>
    And The original file is deleted from the device

    Examples:
      | type     | folderSave | folder    |
      | image    | Images     | All files |
      | video    | Videos     | All files |
      | audio    | Audios     | All files |
      | document | Documents  | All files |
      | document | Documents  | Documents |
      | image    | Images     | Images    |
      | audio    | Audios     | Audio     |

  @Regression
  Scenario Outline: Import a duplicate file of type <type> from folder <folder>
    When the user enters the folder <folder>
    And taps the "+" button
    And selects the option "Import from device"
    And taps the "KEEP ORIGINAL" button
    And taps the "Continue" button
    And selects a file of type <type> from the device
    And taps the "+" button again
    And selects the option "Import from device"
    And taps the "KEEP ORIGINAL" button
    And taps the "Continue" button
    And selects the same file type <type> from the device
    Then the duplicate file is imported correctly with a different name
    And the file of type <type> appears in the list of files in the folder <folderSave>
    And the file appears in the "All files" folder

    Examples:
      | type     | folderSave | folder    |
      | image    | Images     | All files |
      | video    | Videos     | All files |
      | audio    | Audios     | All files |
      | document | Documents  | All files |
      | document | Documents  | Documents |
      | image    | Images     | Images    |
      | audio    | Audios     | Audio     |

  @Smoke
  Scenario: Successfully add a folder
    When the user enters the "All Files" folder
    And taps the "+" button
    And selects the option "Create"
    And enters a folder name "folder1"
    And taps the "OK" button
    Then a folder with the specified name "folder1" is created

  @Regression
  Scenario: Successfully add a folder inside another
    When the user enters the "All Files" folder
    And taps the "+" button
    And selects the option "Create"
    And enters a folder name "folder1"
    And taps the "OK" button
    And enters "folder1"
    And taps the "+" button
    And selects the option "Create"
    And enters a folder name "folder2"
    And taps the "OK" button
    And taps the "Create" button
    Then "folder2" is successfully created inside "folder1"

  @Regression
  Scenario: Attempt to add a new folder with a duplicate name
    When the user enters the "All Files" folder
    And taps the "+" button
    And selects the option "Create"
    And enters a folder name "folder1"
    And taps the "OK" button
    And enters "folder1"
    And taps the "+" button
    And selects the option "Create"
    And enters a folder name "folder1"
    And taps the "OK" button
    Then the folder "folder1" is not created