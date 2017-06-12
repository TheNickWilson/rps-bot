# rps-bot

A very basic reference implementation of a Rock, Paper, Scissors (Dynamite, Waterbomb) bot.  This version always plays ROCK and doesn't track anything at all about its opponent.

Feel free to fork this repo as a starting point which handles the basic plumbing for you, and bring your own functionality!

## The Game

Your bot will face off against another for a game of Rock, Paper, Scissors with a twist.

The basic rules are simple: **rock** beats **scissors**, **scissors** beat **paper**, and **paper** beats **rock**.

The twist, however, is that  **dynamite** beats all of the classic moves.  **Waterbomb** beats **dynamite**, but _loses_ to all of the classic moves.

A game will run for many rounds, and the first player to win enough points (1000 by default) wins the game.

You have a limited supply of dynamite (100 by default).  If you try to throw dynamite after you've run out, you'll throw a waterbomb instead.

Points from draws are carried over to the next round.  So for example if you and your opponent had both played ROCK twice in a row, then the next round is worth three points.

## The API

Your bot needs to implement 3 endpoints:

---------

**POST** http://<your_bot_url>/start

Called once at the start of a match.  Use this to initialise your bot.  Must return HTTP status code 200.  Receives a JSON payload:

| Field             | Example | Description                                                                                               | 
| ----------------- | ------- | --------------------------------------------------------------------------------------------------------- |
| opponentName      | ABC123  | Name of the bot you're playing against                                                                    |
| pointsToWin       | 1000    | Total points needed to win the match                                                                      |
| maxRounds         | 2000    | Maximum number of rounds before the match is a draw                                                       |
| dynamiteCount     | 100     | Number of dynamite you can throw.  Attempts to throw more than this number with throw a waterbomb instead |

---------

**GET** http://<your_bot_url>/move

Called to get your bot's move for the next round.  Must return a JSON payload with HTTP status code 200.
Valid payloads are ROCK, PAPER, SCISSORS, DYNAMITE, WATERBOMB (case sensitive).

---------

**POST** http://<your_bot_url>/move

Called to inform you of your opponent's last move.  Must return HTTP status code 200.  Received a JSON payload:

| Field             | Example | Description                                                                                                    | 
| ----------------- | ------- | ---------------------------------------------------------------------------------------------------------------|
| opponentLastMove  | PAPER   | Last move made by your opponent.  Valid values are ROCK, PAPER, SCISSORS, DYNAMITE, WATERBOMB (case sensitive) |