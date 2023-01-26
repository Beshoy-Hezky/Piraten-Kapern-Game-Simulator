# A1 - Piraten Karpen

  * Author: < Beshoy Hezky >
  * Email: < hezkyb@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project without TRACE mode (player1) vs (player2) :  (choose strategies for player 1 then 2 ex: "random combo") random for player 1 and combo for player 2
    * `mvn exec:java -D exec.args="random combo"`
  * To run the project in TRACE mode (player1) vs (player2) :  (choose strategies for player 1 then 2 ex: "random combo") random for player 1 and combo for player 2
    * `mvn exec:java -D exec.args="random combo" -D TRACE`  
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < when all conditions a feature are satisfied and ready for the user to be used>



### Fixed Backlog 

| MVP? | Id  | Feature                                                       | Status   |  Started  | Delivered |
| :-:  |:-:  |---                                                            | :-:      | :-:       | :-:       |
| YES  | F01 | Roll a dice                                                   |  D       |  16/01/23 | 16/01/23  |
| YES  | F02 | Roll eight dices                                              |  D       |  16/01/23 | 16/01/23  |
| YES  | F03 | Receive 100 score per gold or diamond                         |  D       |  16/01/23 | 16/01/23  |
| YES  | F04 | Reroll feature                                                |  D       |  17/01/23 | 17/01/23  |
| YES  | F05 | Player pick # of dice to reroll or to end turn(strategy)      |  D       |  17/01/23 | 17/01/23  |
| YES  | F06 | Show total score (Win once player reaches 6000)               |  D       |  18/01/23 | 18/01/23  |
| YES  | F07 | Play 42 games and calculate percentage win of each            |  D       |  18/01/23 | 18/01/23  |
| NO   | F08 | Add logging user can see wins and rolls                       |  D       |  21/01/23 | 21/01/23  |
| NO   | F09 | Add group scoring in the game                                 |  D       |  24/01/23 | 24/01/23  |
| NO   | F10 | Reroll smarter dice feature (don't reroll gold and diamond)   |  D       |  24/01/23 | 24/01/23  |
| NO   | F11 | Combo strategy where player should prioritize combos          |  D       |  24/01/23 | 25/01/23  |
| NO   | F12 | Combo strategy accessible from command line                   |  P       |  25/01/23 | 25/01/23  |
| NO   | F13 | Make a functioning card and card deck                         |  P       |  x        | x         |
| NO   | F13 | ...                                                           |  P       |  x        | x         |
| NO   | F13 | ...                                                           |  P       |  x        | x         |
| NO   | F13 | ...                                                           |  P       |  x        | x         |




