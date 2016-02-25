#ifndef FOOT_BALL
#define FOOT_BALL

typedef struct _Player{
  char *firstName;
  char *lastName;
  char *teamName;
  char *position;
  int gamesPlayed;
}Player;

void player_destroy(Player *player);

int sort_games(Player *player_one, Player *player_two);

void player_print(Player *player);

#endif
