# rgb-colors
A Java program that takes a users input for RGB color values, and then displays text in that color

A colour may be specified by its RGB value – the amount of red, green and blue it contains. These amounts are integers between 0 and 255. For example, red is represented by (255, 0, 0), blue by (0, 0, 255) and yellow (which is made up from red and green) by (255, 255, 0). White is (255, 255, 255) and black is (0, 0, 0). The Color class has a constructor with 3 arguments that allows a user to create a Color object by providing the RGB values.

This program is a frame-based application that allows the user to specify RGB values in three text fields, and, when a button is pressed, displays a text message in the chosen colour. The button and the input fields are placed at the bottom of the frame, and the text is written on a panel positioned at the centre (on both the horizontal and vertical axis). The program contains the following features:

* the application initially displays a welcome message (in blue) on the centre panel
* if, when the button is pressed, the content of any of the text fields is not an integer, the invalid field(s) are cleared and an appropriate message will appear on the centre panel; text fields containing integers are, however, never cleared.
* if any of the text fields contain a value less than 0, the value 200 will be used in its place when generating the colour – the displayed value in the text field will also be changed to 200. Similarly, if any of the fields contains a number greater than 255, the value 255 will be used and displayed.
* there is a “Reset” button at the top of the application which, if pressed, will result in all text fields being emptied and the initial welcome message being displayed.
