package thePackmaster.cards.royaltypack;

public class AbstractRoyaltyCard extends AbstractPackmasterCard {

    public AbstractRoyaltyCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target)
    {
        super(cardID, cost, type, rarity, target, "royalty");

    }

    public AbstractRoyaltyCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color)
    {
        super(cardID, cost, type, rarity, target, color,"royalty");

    }

}
