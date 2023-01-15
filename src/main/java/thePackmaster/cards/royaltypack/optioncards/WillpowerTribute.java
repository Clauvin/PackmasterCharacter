package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.BufferPower;
import thePackmaster.actions.royaltypack.PayTributeAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WillpowerTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("WillpowerTribute");
    public final static int TRIBUTE_GOLD_AMOUNT = 10;

    public WillpowerTribute(){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.atb(new PayTributeAction(TRIBUTE_GOLD_AMOUNT));
        Wiz.atb(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ArtifactPower(abstractPlayer, 2)));
        Wiz.atb(new ApplyPowerAction(abstractPlayer, abstractPlayer, new BufferPower(abstractPlayer, 2)));
    }
}
