@Lock

Feature: Lock Options
  
  Background:
    Given The user opens the app for the first time

@Smoke

Scenario Outline: register with password
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "Contraseña" button
  And types the <password>
  And tap the "Siguiente" button  
  And types the <password> to confirm
  And tap the "Siguiente" button  
  Then a successfully registered message is displayed to the user and a link to landing page
  
  Examples:
  | password  |
  | abcdef    |
  
@Regression

Scenario Outline: Failed password confirmation and lenght
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "Contraseña" button
  And types a <password_a>
  And tap the "Siguiente" button 
  And types a <password_b>
  And tap the "Siguiente" button  
  Then a message is displayed to the user, warning the passwords are not the same
  
  Examples:
  | password_a  | password_b |
  | abcdef      | abcabc     |

@Regression

Scenario Outline: Failed password lenght
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "Contraseña" button
  And types a <password>
  Then the "Siguiente" button remains disabled 
  
  Examples:
  | password  |
  | abcde     |

@Smoke

Scenario Outline: register with PIN
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "PIN" button
  And types a <PIN>
  And tap the "Siguiente" button  
  And types the <PIN> to confirm
  And tap the "Siguiente" button  
  Then A successfully registered message is displayed to the user and a link to landing page
  
  Examples:
  | PIN    |
  | 123456 |
  
@Regression

Scenario Outline: Failed PIN confirmation
When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "PIN" button
  And types a <PIN_a>
  And tap the "Siguiente" button  
  And types a <PIN_b>
  And tap the "Siguiente" button
  Then a message is displayed to the user, warning the PIN numbers are not the same
  
  Examples:
  | PIN_a  | PIN_b  |
  | 123456 | 654321 |

@Regression

Scenario Outline: Failed PIN lenght
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "PIN" button
  And types a <PIN>
  Then the "Siguiente" button remains disabled
  
  Examples:
  | PIN   |
  | 12345 |

@Smoke

Scenario: register with pattern
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "Patrón" button
  And draws a pattern with no less than six points
  And tap the "Siguiente" button  
  And draws the same pattern to confirm
  And tap the "Siguiente" button  
  Then A successfully registered message is displayed to the user and a link to landing page

@Regression

Scenario: Failed pattern confirmation
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "Patrón" button
  And draws a pattern with no less than six points
  And tap the "Siguiente" button  
  And draws a different pattern with no less than six points
  And tap the "Siguiente" button  
  Then a message is displayed to the user, warning the patterns are not the same

@Regression

Scenario: Failed minimum number of points in pattern
  When the user tap the "EMPEZAR" button
  And tap the "Siguiente" button until reaching the lock options
  And tap the "Patrón" button
  And draws a pattern with a number of points less than six
  Then the "Siguiente" button remains disabled
  










