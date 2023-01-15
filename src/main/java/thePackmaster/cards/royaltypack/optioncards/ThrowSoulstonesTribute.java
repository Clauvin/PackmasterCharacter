package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.utility.QueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.BlizzardEffect;
import thePackmaster.actions.royaltypack.PayTributeAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ThrowSoulstonesTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("ThrowSoulstonesTribute");
    public final static int DAMAGE = 15;
    public final static int TRIBUTE_GOLD_AMOUNT = 10;
    private AbstractCard originalThrowSoulstonesCard;

    public ThrowSoulstonesTribute(AbstractCard originalTSCard){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        baseDamage = damage = DAMAGE;
        originalThrowSoulstonesCard = originalTSCard;
    }

    @Override
    public void upp() {
        this.upgradeDamage(5);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption(){
        Wiz.atb(new PayTributeAction(TRIBUTE_GOLD_AMOUNT));
        if (Settings.FAST_MODE) {
            this.addToBot(new VFXAction(new BlizzardEffect(this.damage, AbstractDungeon.getMonsters().shouldFlipVfx()), 0.25F));
        } else {
            this.addToBot(new VFXAction(new BlizzardEffect(this.damage, AbstractDungeon.getMonsters().shouldFlipVfx()), 0.5F));
        }
        Wiz.doAllDmg(baseDamage, AbstractGameAction.AttackEffect.NONE, DamageInfo.DamageType.NORMAL, false);
        //Wiz.atb(new NewQueueCardAction(originalThrowSoulstonesCard, false));
    }

}
