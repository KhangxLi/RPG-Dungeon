# RPG-Dungeon
Text-based survival rpg that plays a bit like pokemon.  
This game consolidates all the material I've learned in my first programming course: OOP with Java. This includes Classes and Arrays. It is played in the command-line. Java is needed to run the program.

### Game Instructions

#### D-Dungeon: 
When you enter a room, you must defeat all monsters in it. Each room generates random monsters while staying within the its difficulty level. The room number indicates its difficulty level. The deeper you are in the dungeon, the higher the room number and the more variable the room can be. You can leave the dungeon everytime you finish a room. Watch your HP and STA levels. You are very weakened when you enter a room with 0 stamina and you lose the game when you have 0 HP.  

#### P-Profile: 
You can access your profile from anywhere except for in the dungeon by entering 'P'.  
__HP__: is your health. If it reaches 0, it's game over.  
__ATK__: is how much damage you deal each attack.  
__DEF__: is how much damage you can take each time you're attacked before losing HP.  
__DEX__: decides your probability of doing combos and doging attacks.  
__STA__: is your stamina. If it's at zero when you enter a dungeon room, your ATK and DEX will reduced by half.  
__XP__: is your experience points that you can exchange to train ATK, DEF, DEX.  
__Monsters Defeated__: is how many monsters you've defeated in total.  
__Deepest Room Attained__: is the deepest or best room that you have attained.  

#### G-Gym: 
Train yourself in the Gym by exchanging XP. It's better to buy in bulk since prices change. Each training session costs stamina. You gain XP by defeating monsters. You gain the same number of XP as a monster's ID# plus 1 when you defeat it. 

#### H-Home: 
__R-Rest__: will reset your current stamina levels to their max capacity and will put your ATK and DEX back to normal if you've fought while exhausted. Your max capacity of stamina follows this formula: 10 + NbOfKills/2.  
__E-Eat__: will reset your current HP levels to their max capacity. Your max HP follows this formula: 10 + (ATK+DEF+DEX+MaxStamina)/3.   

#### S-Store: 
Buy items by exchanging Moni, the game's currency. You can use items anytime before fighting after you've entered a dungeon room.  
__HP Potion__: recovers 5 HP.  
__STA Potion__: recovers 5 STA.  
__Camouflage__: lets you skip a room.  
__Mega Booster__: lets you skip 5 rooms.  
__CheckPoint__: lets you leave a check point at the beginning of a room.  
You can see your items on your profile.  
You gain Moni by defeating monsters. The formula for Moni gained for each monster is the monster's level times 3.  

#### X-Monster Database: 
This shows the monster you've encountered and their information.  


