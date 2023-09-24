SOFT2201 ASM2

Projectiles must be created using the Factory method.
The state/colour change of each bunker must be controlled using the State pattern.
The enemies and bunkers must be created using the Builder pattern.
The behaviour of enemy projectiles will be controlled using the Strategy pattern.


Your space invaders game is now expected to support the following features in your code:

The game can be created in different sizes, with different sized bunkers at different positions, which must be configurable, defined in and read from the sample JSON configuration file. The colour, initial position (as an x-y coordinate), speed and lives of the player spaceship must be configurable, specified in and read from the sample JSON configuration file. Furthermore, the Enemy positions and projectile strategies are defined within the JSON configuration file.

The Bunkers  
- If a bunker is hit by a projectile (either from the player or an enemy), the bunker receives damage (i.e. the colour changes) and the projectile is destroyed.
- If a bunker is hit 3 times, it should be removed from the game.
- The bunker will change colour according to the number of hits it has received, this represents its current state. Green = 0 hits, Yellow = 1 hit, Red = 2 hits.

The Player Spaceship  
- You must be able to control the spaceship with the arrow keys to move the spaceship left and right across the screen.  
- Pressing the spacebar should shoot a projectile (Slow Straight Projectile) from the players position, moving in an upwards direction. This projectile will either hit an Alien or Bunker, or disappear at the top of the screen.   
- The projectile can be shot at anytime (even while moving), however, only 1 player projectile can be on screen at a given time.  
- If a player projectile collides with an enemy projectile, both projectiles are destroyed.  
- If the player spaceship receives a hit from an enemy projectile, 1 life will be deducted. If there are no lives left, the game ends.

The Enemies  
- All enemies must be able to move back and forth horizontally across the screen in an organised group, while descending down when they reach the edges of the screen.
- Enemies must be removed from the game when they are hit by a player projectile. When this occurs, the speed of all enemies is slightly increased.
- If any enemy reaches the bottom of the screen or reaches the player, the game ends.
- If an enemy touches a bunker, the bunker is immediately removed from the game (i.e. the bunkers should not affect enemy movement).
- Enemies shoot projectiles at the player at random intervals. There can be no more than 3 enemy projectiles on screen at a time.
- Each enemy will shoot a projectile with a particular behaviour. The two behaviours are "Fast Straight Projectiles" and "Slow Straight Projectiles". The fast straight projectiles should travel twice as fast as the slow straight projectiles. This should be implemented using the strategy pattern,