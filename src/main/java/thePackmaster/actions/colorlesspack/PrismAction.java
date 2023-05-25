package thePackmaster.actions.colorlesspack;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.vfx.colorlesspack.ColoredVerticalAttackEffect;

import static thePackmaster.util.Wiz.att;

public class PrismAction extends AbstractGameAction {
    private final AbstractCard card;

    public PrismAction(AbstractCard card) {
        this.card = card;
        this.actionType = ActionType.DAMAGE;
        this.startDuration = 0.1F;
        this.duration = this.startDuration;
    }

    public void update() {
        isDone = true;
        AbstractMonster q = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
        if (q != null) {
            card.calculateCardDamage(q);
            att(new DamageAction(q, new DamageInfo(AbstractDungeon.player, card.damage, card.damageTypeForTurn), AttackEffect.NONE));
            att(new VFXAction(new ColoredVerticalAttackEffect(q.hb.x + MathUtils.random(q.hb.width / 3, ((q.hb.width / 3) * 2)), q.hb.cY, true, new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1))));
        }
    }
}
