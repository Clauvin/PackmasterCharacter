package thePackmaster.cards.royaltypack.optioncards;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.PayTributeAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ForcefieldTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("ForcefieldTribute");
    public final static int TRIBUTE_GOLD_AMOUNT = 9;
    private int temporaryHpGained;

    public ForcefieldTribute(){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
        temporaryHpGained = 0;
        baseMagicNumber = magicNumber = temporaryHpGained;
    }

    public ForcefieldTribute(int temporaryHpGained){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
        this.temporaryHpGained = temporaryHpGained;
        baseMagicNumber = magicNumber = this.temporaryHpGained;
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
        Wiz.atb(new PayTributeAction(TRIBUTE_GOLD_AMOUNT));
        Wiz.atb(new AddTemporaryHPAction(AbstractDungeon.player,
                AbstractDungeon.player, this.magicNumber));
    }
}
