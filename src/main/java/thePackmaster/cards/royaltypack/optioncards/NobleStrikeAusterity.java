package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.utility.ConditionalDrawAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class NobleStrikeAusterity extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleStrikeAusterity");
    public final static int GOLD_GAINED = 5;

    public NobleStrikeAusterity(){
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
        Wiz.atb(new GainGoldAction(GOLD_GAINED));
        Wiz.atb(new DrawCardAction(magicNumber));
    }
}
