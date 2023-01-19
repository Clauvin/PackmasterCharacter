package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.BoundlessTalentAusterity;
import thePackmaster.cards.royaltypack.optioncards.BoundlessTalentTribute;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Forcefield extends AbstractPackmasterCard {

    public final static String ID = makeID("Forcefield");
    public final static int TRIBUTEMAXHP = 16;
    public final static int AUSTERITYMAXHP = 8;

    public Forcefield() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = AUSTERITYMAXHP;
        baseSecondMagic = secondMagic = TRIBUTEMAXHP;
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(3);
        this.upgradeSecondMagic(6);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.atb(new DiscardAction(abstractPlayer, abstractPlayer, 1, true));

        AbstractPackmasterCard forcefieldTributeChoiceCard = new ForcefieldTribute();
        AbstractPackmasterCard forcefieldAusterityChoiceCard = new ForcefieldAusterity();
        for (int i = 0; i < this.timesUpgraded; i++){
            forcefieldTributeChoiceCard.upgrade();
            forcefieldAusterityChoiceCard.upgrade();
        }

        Wiz.atb(new TributeOrAusterityAction(forcefieldTributeChoiceCard, forcefieldAusterityChoiceCard));
    }
}
