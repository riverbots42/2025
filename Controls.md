# Controls

Manual controls are going to be split into two modes on the controller; One mode controls the algae system and the other controls the lift system. The mode will be switched using the back button, and the main control changes between the different modes will be the bumpers and triggers. In the algae system, actuators will move the system up and down and also suck in and spit out algae. So, in the algae mode, the left bumper will suck in, the right bumper will spit out, the left trigger will raise the algae system, and the right trigger will lower the system. In the lift system, it will just be a pushing-down motion to lift the robot/itself up. This will be controlled with the triggers; left trigger down and right trigger up. For movement, the left stick will always be the same movement cartesian and the right stick will rotate the robot. Each of the ABXY buttons will be set to a certain point to go to. These points will be found using the April Tags on the field. While a button is held, it will direct itself and move towards a point on the field and stop once the button is released. So far, we have 3 button points set in stone: Go to the algae processor, go to the reef, or go to cages. This one-touch navigation will help us move around the field in a simple way, especially since it will be hard to see the robot at all times maneuver easily. The code side of the one-touch navigation will have the robot looking for an April Tag associated with the destination. An example would be if a button was held to go to a reef station, the robot would search for the IDs associated with the reef and go to the closest one.



```
April Tag ID’s
Reef
  Red: 6, 7, 8, 9, 10, 11
  Blue: 17, 18, 19, 20, 21, 22
Processor
  Red: 3
  Blue: 16
Barge
  Red:
    Close to algae processor: 4
    Away from algae processor: 5
Blue:
  Close to Algae processor: 15
  Close to Algae processor: 14
```
