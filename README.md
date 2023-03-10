# Stamp Exchange

> Jane and Alice each have a collection of stamps. Each stamp has a number that uniquely identifies it. In order to keep increasing their collections, they want to trade repeated ones, always keeping a spare, just in case. They are going to meet soon and exchange stamps. They agreed to bring all their repeated stamps that the other person doesn't have, or has only one.

Write a program to help Jane and Alice exchange stamps: it receives two unordered arrays of stamps that Jane and Alice has, and return two unordered arrays of stamps that Jane and Alice will get from the other side. Output order of stamps in each array is not relevant, however the first array is always Jane’s stamps, and the second array is always Alice’s stamps in both input and output.

Example inputs and outputs:

Input|Output
--|--
{ 1, 7, 3, 1, 7, 4, 5, 1, 7, 1 }, { 2, 3, 3, 2, 4, 3, 2 }| { 2, 3 }, { 1, 1, 7 }
{ 1, 2, 3, 4, 4 }, { 4, 4, 4, 5, 6, 7 }| { <empty>}, { <empty>}
{ 5, 4, 4, 3, 3, 3, 3 }, { 1, 3 }| { <empty> }, { 3, 3 }

## Usage
### Bash script
Run and pass the args
```bash
chmod +x runAliceJaneTrade.sh

# it'll ignore the spaces automatically
 ./runAliceJaneTrade.sh "1, 7, 3, 1, 7, 4, 5, 1, 7, 1" "2, 3, 3, 2, 4, 3, 2"
```

### Run the gradle
- [optional] open the project in an IDE (e.g. IntelliJ)
- Run the `Main.kt`.main and **pass the args** as scanner readLine()
- Or run `./gradlew run --args "\"1,2,3,4\" \"1,2,4,5\""`

### Run tests
```bash
./gradlew test
```