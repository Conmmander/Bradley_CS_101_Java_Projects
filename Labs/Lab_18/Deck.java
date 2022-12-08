import java.util.Random;

public class Deck
{
    private final int DECK_SIZE = 52;
    private Card[] deck;

    // Top of the deck is index 0; bottom is index 51.
    private int currentTop;
    
    //
    // Allocates a default deck of 52 cards with four suits.
    //
    public Deck()
    {
        deck = new Card[DECK_SIZE];
        currentTop = 0;

        
        int index = 0;
        for (Card.SuitT suit : Card.SuitT.values())
        {
            for (Card.FaceT face : Card.FaceT.values())
            {
                deck[index++] = new Card(suit, face);
            }
        }
    }
    
    //
    // May assume a full deck.
    //
    // Shuffles by switching two random cards in the deck many times.
    //
    public void shuffle()
    {
        Random rng = new Random();
        
        final int ITERATIONS = 1000;
        for (int count = 0; count < ITERATIONS; count++)
        {
        	int firstCard = rng.nextInt(0, 52);
        	int secondCard = rng.nextInt(0, 52);
        	Card tempCard = this.deck[firstCard];
        	this.deck[firstCard] = this.deck[secondCard];
        	this.deck[secondCard] = tempCard;
        }
    }

    //
    // Computes the number of cards that remain in the deck:
    // deck count minus the current top index
    //
    public int cardsRemaining()
    {
    	int count = 0;
    	for (int i = this.currentTop + 1; i < this.deck.length; i++) {
    		++count;
    	}
        return count;
    }
    
    //
    // Returns the top card from the deck.
    //
    public Card deal() throws DeckException
    {
    	Card cardToDeal = this.deck[this.currentTop];
    	++this.currentTop;
    	if (this.currentTop > 51) {
    		throw new DeckException("No more cards in the deck!");
    	}
    	return cardToDeal;
    }

    //
    // Returns the top card from the deck.
    //
    public Card[] deal(int numCards) throws DeckException
    {
        
        Card[] returnSet = new Card[numCards];
        for (int i = 0; i < numCards; ++i) {
        	returnSet[i] = this.deal();
        }
        return returnSet;
    }
    
    
    //
    // Builds and returns a meaningful representation of the cards that
    // remain in the deck.
    //
    public String toString()
    {
        String retStr = "";
        
        for (int i = this.currentTop; i < this.deck.length; ++i) {
        	retStr += this.deck[i].toString() + "\n";
        }
        
        return retStr;
    }
}
