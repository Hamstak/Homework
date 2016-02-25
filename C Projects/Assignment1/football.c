#include <stdlib.h>
#include <string.h>
#include <assert.h>

void player_destroy(Player *player){
  free(player->firstName);
  free(player->lastName);
  free(player->teamName);
  free(player->position);
  free(player);
}

int sort_games(Player *player_one, Player *player_two){
  return player_one->gamesPlayed - player_two->gamesPlayed;
}

void player_print(Player *player){
  printf("%s, %s Team: %s, Games Played: %d\n", player->lastName, player->firstName, player->teamName, player->gamesPlayed);
}
