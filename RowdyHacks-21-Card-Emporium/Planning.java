/*



  public static int goToWar(War warGame, ArrayList<Integer> competitors){

    Deck competingCards = new Deck(0);

    //First we will check if all players have the ability to spend 4 cards. If any do not, all their cards go to the winning pile and they are removed from the game

    for (int i = 0; i < competitors.size(); i++) {
      if (warGame.playerList.get(competitors.get(i)).getHand().size() < 4) {
        
        for(int j = 0; j < competitors.get(i).getHand().size(); j++){
          Card temp = warGame.playerList.get(competitors.get(i)).hand(0); 
          warGame.playerList.get(competitors.get(i)).transferCard(temp, cumCards);
          competitors.remove(i);
        }

        updatePlayerNo(0, warGame); //we don't care about what this returns, just care that it updates the playerlist. 

      }
    }

    for (int i = 0; i < competitors.size(); i++) {  
      //stores the top 3 cards of competing players
      Card temp = warGame.playerList.get(competitors.get(i)).hand(0); 
      Card temp2 = warGame.playerList.get(competitors.get(i)).hand(1);
      Card temp3 = warGame.playerList.get(competitors.get(i)).hand(2);
      
      //transfers the top 3 cards of competing players' hand into the winning pile. 
      warGame.playerList.get(competitors.get(i)).transferCard(temp, cumCards); 
      warGame.playerList.get(competitors.get(i)).transferCard(temp2, cumCards);
      warGame.playerList.get(competitors.get(i)).transferCard(temp3, cumCards);
    }  
    
    for(int i = 0; i < competitors.size(); i++) {
      Card temp = warGame.playerList.get(competitors.get(i)).hand(0);
      warGame.playerList.get(competitors.get(i)).transferCard(temp, competingCards); 
    }

    // find the max and which ONES (plural!) have the max
    
    ArrayList<Integer> cardNums  = new ArrayList<Integer>();  // need to create an arraylist of NUMBERS, not type Cards. 
  
    for (int i = 0; i < competingCards.size(); i++) {
        cardNums.add(competingCards.getDeck().get(i).getCardNo());
    }

    int max = cardNums.max;
    ArrayList<Integer> winningPlayers = new ArrayList<Integer>();
    
    for(int i = 0; i < competingCards.size(); i++){
      if(cardNums.get(i) == max){
        winningPlayers.add(i);
      }
    }

    if(winningPlayers.size() > 1){
      goToWar(warGame, winningPlayers);
    }
    
    else {
      int winner = winningPlayers.get(0);
      for (int i = 0; i < cumCards.getDeck().size(); i++) {
        warGame.playerList.get(winner).hand.add(cumCards.getDeck.get(i));
        cumCards.clearDeck();
      }
      return winner;

    }
      
  }



/*
Returns the index of the playerlist that refers to the winning player of the round. 

  public static int winnerOfRound(War warGame) {

  //This segment will arrange a deck of cards that consists of the topcard from each player. 

    for (int i = 0; i < warGame.playerList.size(); i++) {
      Card temp = warGame.playerList.get(i).hand(0); //stores the top card of player's hand. 
      warGame.playerList.get(i).transferCard(temp, cumCards); //transfers the top card to the cumCards deck. 
    }

  // find the max and which ONES (plural!) have the max
    
    ArrayList<Integer> cardNums  = new ArrayList<Integer>();  // need to create an arraylist of NUMBERS, not type Cards. 
  
    for (int i = 0; i < cumCards.size(); i++) {
        cardNums.add(cumCards.getDeck().get(i).getCardNo());
    }

    int max = cardNums.max;
    
    ArrayList<Integer> winningPlayers = new ArrayList<Integer>();
    
    for(int i = 0; i < cumCards.size(); i++){
      if(cardNums.get(i) == max){
        winningPlayers.add(i);
      }
    }


If multiple players have the max card value in the round, go to war. If not, return the one player (the only player in the winningPlayers array) index.
*

    if(winningPlayers.size() > 1){
      goToWar(warGame, winningPlayers);
    }
    // If only one winner, updates the winner's deck with the cumCards cards. returns which player won. 
    else {
    int winner = winningPlayers.get(0);
      for (int i = 0; i <cumCards.size(); i++) {
        cumCard.transferCard(cumCard.get(0), warGame.playerList.get(winner).hand);
      return winner;
      }
    }
    
  }




   public void transferCard(Card tCard, Deck otherDeck) {
    int index = -1; // 
    
    for (int i = 0; i < deck.size(); i++) {
      if (this.deck.get(i).toString().equals(tCard.toString())) {
        index = i;
      }
    }
    
    this.deck.remove(index);
    otherDeck.deck.add(tCard);
  }




    public static ArrayList<Integer> toWar(War warGame, ArrayList<Integer> winningPlayers) {
    
    /*
    Any player who has less than 4 cards loses all their cards to the pile and is kicked from the game. 
    

    ArrayList<Integer> listOfUnder4 = new ArrayList<Integer>();
    
    System.out.println(warGame.playerList.get(0).getHand().getDeck().toString());
    System.out.println(warGame.playerList.get(1).getHand().getDeck().toString());
    System.out.println(warGame.playerList.get(2).getHand().getDeck().toString());


    for (int i = 0; i < winningPlayers.size(); i++) { 
      
      Deck sizeOfPlayerUnder4 = warGame.playerList.get(winningPlayers.get(i)).getHand();
      
      if (sizeOfPlayerUnder4.getDeck().size() < 4) {  
        for(int j = 0; j < sizeOfPlayerUnder4.getDeck().size(); j++){ 
          warGame.playerList.get(winningPlayers.get(i)).hand.transferCard(cumCards);
        }
        listOfUnder4.add(i); //create an arraylist of the ones under four, then remove after.
      }
    }
    
    for(int index: listOfUnder4){
      warGame.playerList.remove(index);
    }


    /*
    This will put top three cards from each player's deck into the cumCards pile. 
    
    Deck cumCardsNEW = new Deck(0);
    for(int i = 0; i < winningPlayers.size(); i++){
      for(int j = 0; j < 3; j++){
        
          Card temp = warGame.playerList.get(winningPlayers.get(i)).getHand().getDeck().get(0);
          
          warGame.playerList.get(winningPlayers.get(i)).hand.transferCard(Main.cumCards);

          cumCardsNEW.getDeck().add(temp);
      }
    }

    // find the max and which ONES (plural!) have the max
    ArrayList<Integer> cardNums = new ArrayList<Integer>(); 
    
    // need to create an arraylist of NUMBERS, not type Cards.
    for (int i = 0; i < winningPlayers.size(); i++) {
      cardNums.add(warGame.playerList.get(winningPlayers.get(i)).getHand().getDeck().get(0).getCardNo());
    }
    int max = Collections.max(cardNums);

    ArrayList<Integer> winningPlayersNEW = new ArrayList<Integer>();

    for (int i = 0; i < cardNums.size(); i++) {
      if (cardNums.get(i) == max) {
        winningPlayersNEW.add(i);
      }
    }
    //System.out.println(winningPlayersNEW);
    
    //System.out.println(cardNums);

    for (Card x: cumCardsNEW.getDeck()) {
      cumCardsNEW.transferCard(cumCards);
    }

    if(winningPlayersNEW.size() > 1){
      cumCardsNEW.clearDeck();
      winningPlayersNEW = toWar(warGame, winningPlayersNEW);
    }
    cumCardsNEW.clearDeck();
    return winningPlayersNEW;
  }
*/


