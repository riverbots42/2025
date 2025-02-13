# Controls

Manual controls are going to be split into two modes on the controller
* One mode controls the algae system and the other controls the lift system
  * The mode will be switched using the back button, and the main control changes between the modes will be the bumpers and triggers.
  * Algae system:
    * Actuators will move the system up and down and also suck in and spit out algae.
    * Left bumper will suck in
    * Right bumper will spit out
    * Left trigger will raise the algae system
    * Right trigger will lower the system.
  * Lift system:
    * Actuators will be enacting a pushing-down motion to lift itself up onto the cage.
      * Left trigger will push down
      * Right trigger will release it back up. \
     

Movement (won’t change based on mode)
* Left stick will control robot in a cartesian plane
  * Up moves robot forward, down moves backwards, left and right moves left and right
* Right stick will rotate the robot
  * Left rotates the robot counterclockwise, Right rotates the robot clockwise \
 

Button Controls
* Each of the ABXY buttons will be set to a certain destination on the field
  * These points will be found using the April Tags on the field.
  * While a button is held, it will direct itself and move towards a point on the field and stop once the button is released. 
* So far, we have 3 button destinations set in stone: 
  * Go to the algae processor, 
  * Go to the reef, 
  * Go to the cages.
* The code side of the one-touch navigation will have the robot looking for an April Tag associated with the destination. 
  * An example would be if a button was held to go to a reef station, the robot would search for the id’s associated with the reef and use the coordinates and distance from the tag to calculate the robot’s position, which then allows the robot to navigate into the correct position.




## April Tag ID’s
* Reef
  - Red: 6, 7, 8, 9, 10, 11
  - Blue: 17, 18, 19, 20, 21, 22
* Processor
  - Red: 3
  - Blue: 16
* Barge
  - Red:
    - Close to algae processor: 4
    - Away from algae processor: 5
- Blue:
  - Close to Algae processor: 15
  - Close to Algae processor: 14

