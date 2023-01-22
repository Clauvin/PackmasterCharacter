package thePackmaster.cards.royaltypack.optioncards;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ForcefieldAusterity extends AbstractPackmasterCard {

    public final static String ID = makeID("ForcefieldAusterity");
    public final static int TEMPORARY_HP_GAINED = 8;

    public ForcefieldAusterity(){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
        baseMagicNumber = magicNumber = TEMPORARY_HP_GAINED;
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(3);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption() {
        Wiz.atb(new AddTemporaryHPAction(AbstractDungeon.player,
                AbstractDungeon.player, this.magicNumber));
    }
}