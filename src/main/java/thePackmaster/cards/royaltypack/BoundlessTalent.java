package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BoundlessTalent extends AbstractPackmasterCard {

    public final static String ID = makeID("BoundlessTalent");

    public BoundlessTalent() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = 5;
        baseSecondMagic = 1;
    }

    @Override
    public void upp() {
        baseSecondMagic += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        //Austerity: Gain 5 Gold. Tribute 5: Copy one card in your hand, it has Exhaust. Exhaust.
    }
}
