package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Willpower extends AbstractPackmasterCard {

    public final static String ID = makeID("Willpower");

    public Willpower(){
        super(ID, 0, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        isInnate = false;
    }

    @Override
    public void upp() {
        isInnate = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        //Austerity: Gain 1 Artifact. Tribute 10: Gain 1 Artifact and 1 Buffer.
    }
}
