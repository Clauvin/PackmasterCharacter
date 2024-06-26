package thePackmaster.cards.distortionpack;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.distortionpack.RuePower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;
import static thePackmaster.util.Wiz.atb;

public class Rue extends AbstractDistortionCard {
    public final static String ID = makeID("Rue");
    // intellij stuff skill, none, rare, , , , , 1, 1

    private static final int EXHAUST = 3;

    public Rue() {
        super(ID, 0, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainEnergyAction(2));
        atb(new DrawCardAction(this.magicNumber));
        applyToSelf(new RuePower(p, EXHAUST));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}