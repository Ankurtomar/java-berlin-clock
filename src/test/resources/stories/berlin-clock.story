Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Wrong Input 1
When the time is 24:00:01
Then Exception message look like Invalid Time provided.

Scenario: Wrong Input 2
When the time is -1:00:00
Then Exception message look like Invalid Time provided.

Scenario: Wrong Input 3
When the time is 25:00:00
Then Exception message look like Invalid Time provided.

Scenario: Wrong Input 4
When the time is 00:-10:00
Then Exception message look like Invalid Time provided.

Scenario: Wrong Input 4
When the time is 00:00:-10
Then Exception message look like Invalid Time provided.
