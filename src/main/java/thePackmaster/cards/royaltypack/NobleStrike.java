package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.audio.Sfx;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class NobleStrike extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleStrike");

    public NobleStrike(){
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 6;
        baseMagicNumber = 5;
        baseSecondMagic = 1;
    }

    @Override
    public void upp() {
        baseSecondMagic += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        dmg(abstractMonster, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        //Add Austerity: Gain 5 Gold and draw a card. Tribute 5: Draw an Attack.
        //Also, add sfx and vfx sounds from Buriedbornes
    }
}
