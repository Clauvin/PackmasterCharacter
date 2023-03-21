package thePackmaster.cards.colorlesspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class GolfBall extends AbstractColorlessPackCard {
    public final static String ID = makeID("GolfBall");
    // intellij stuff attack, enemy, special, , , , , , 

    public GolfBall() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY);
        isEthereal = true;
        exhaust = true;
    }


    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}