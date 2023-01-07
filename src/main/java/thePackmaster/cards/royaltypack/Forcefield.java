package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Forcefield extends AbstractPackmasterCard {

    public final static String ID = makeID("Forcefield");

    public Forcefield() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 8;
        baseMagicNumber = 16;
    }

    @Override
    public void upp() {
        baseBlock += 3;
        magicNumber += 6;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.atb(new DiscardAction(abstractPlayer, abstractPlayer, 1, true));
        //Create Action for TributeOrAusterity effect
    }
}
