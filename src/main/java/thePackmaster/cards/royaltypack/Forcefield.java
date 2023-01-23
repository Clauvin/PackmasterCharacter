package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.BoundlessTalentAusterity;
import thePackmaster.cards.royaltypack.optioncards.BoundlessTalentTribute;
import thePackmaster.cards.royaltypack.optioncards.ForcefieldAusterity;
import thePackmaster.cards.royaltypack.optioncards.ForcefieldTribute;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Forcefield extends AbstractPackmasterCard {

    public final static String ID = makeID("Forcefield");
    public final static int TRIBUTE_MAXHP = 13;
    public final static int AUSTERITY_MAXHP = 8;

    public Forcefield() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = AUSTERITY_MAXHP;
        baseSecondMagic = secondMagic = TRIBUTE_MAXHP;
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(3);
        this.upgradeSecondMagic(3);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.atb(new DiscardAction(abstractPlayer, abstractPlayer, 1, true));

        AbstractPackmasterCard forcefieldTributeChoiceCard = new ForcefieldTribute(secondMagic);
        AbstractPackmasterCard forcefieldAusterityChoiceCard = new ForcefieldAusterity(magicNumber);
        for (int i = 0; i < this.timesUpgraded; i++){
            forcefieldTributeChoiceCard.upgrade();
            forcefieldAusterityChoiceCard.upgrade();
        }

        Wiz.atb(new TributeOrAusterityAction(forcefieldTributeChoiceCard, forcefieldAusterityChoiceCard));
    }
}
