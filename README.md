# A1 - Piraten Karpen

  * Author: < You name here >
  * Email: < Your email here >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
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

### Backlog 

| MVP? | Id  | Feature          | Status  |  Started  | Delivered |
| :-:  |:-:  |---               | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice       |  S      | 01/01/23  |           |
| x   | F02 | Roll eight dices  |  B (F01)|           |           |
| x   | F03 | Make two players  |  B (F01)|           |           |
| x   | F04 | Roll eight dices  |  B (F01) |   |
| x   | F05 | Roll eight dices  |  B (F01) |   |
| NO  | F06 | Select how many games as command-line arg.  |  P  |   |
| NO  | F07 | end of game with three cranes | P | |
| YES  | F08 | Player keeping random dice at their turn | B (F02) | | 
| NO  | F09 | Score points: 3-of-a-kind | B (F04) | | 
| ... | ... | ... |

### Fixed Backlog 

| MVP? | Id  | Feature                                           | Status   |  Started  | Delivered |
| :-: |:-:  |---                                                 | :-:      | :-:       | :-:       |
| YES | F01 | Roll a dice                                        |  D       |  16/01/23 | 16/01/23  |
| YES | F02 | Roll eight dices                                   |  D       |  16/01/23 | 16/01/23  |
| YES | F03 | Receive 100 score per gold or diamond              |  D       |  16/01/23 | 16/01/23  |
| YES | F04 | Player pick # of dice to reroll or to end turn     |  B (F02) |           |           |
| YES | F05 | Show total score (Win once player reaches 6000)    |  P       |           |           |
| YES | F06 | Play 42 games and calculate percentage win of each |  B       |           |           |


