package thePackmaster.cards.royaltypack.optioncards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

@AutoAdd.Ignore
public class WillpowerAusterity extends AbstractRoyaltyCard {

    public final static String ID = makeID("WillpowerAusterity");

    public WillpowerAusterity(){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption() {
        Wiz.atb(new ApplyPowerAction(AbstractDungeon.player,
                AbstractDungeon.player,
                new ArtifactPower(AbstractDungeon.player, 1)));
    }
}
