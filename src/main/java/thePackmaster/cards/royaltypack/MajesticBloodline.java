package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MajesticBloodline extends AbstractPackmasterCard {

    public final static String ID = makeID("MajesticBloodline");

    public MajesticBloodline(){
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        exhaust = true;
        baseMagicNumber = 3;
    }

    @Override
    public void upp() {
        baseMagicNumber += 2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        //Create action for shuffling card after Discovery type effect
        //Show Tribute effect choice.
    }
}
