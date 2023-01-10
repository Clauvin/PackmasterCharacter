package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.ConditionalDrawAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class NobleStrikeTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleStrikeTribute");
    public final static int TRIBUTE_GOLD_AMOUNT = 5;

    public NobleStrikeTribute(){
        super(ID, -1, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
        baseMagicNumber = 1;
    }

    @Override
    public void upp() {
        magicNumber += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption(){
        Wiz.atb(new ConditionalDrawAction(magicNumber, CardType.ATTACK));
    }
}
