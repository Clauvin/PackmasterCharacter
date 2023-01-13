package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.audio.Sfx;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.NobleStrikeAusterity;
import thePackmaster.cards.royaltypack.optioncards.NobleStrikeTribute;
import thePackmaster.util.Wiz;

import javax.swing.*;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class NobleStrike extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleStrike");


    public NobleStrike(){
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 6;
        baseMagicNumber = magicNumber = 1;
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        dmg(abstractMonster, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        AbstractPackmasterCard nsTributeChoiceCard = new NobleStrikeTribute();
        AbstractPackmasterCard nsAusterityChoiceCard = new NobleStrikeAusterity();
        for (int i = 0; i < magicNumber - 1; i++){
            nsTributeChoiceCard.upgrade();
            nsAusterityChoiceCard.upgrade();
        }


        Wiz.atb(new TributeOrAusterityAction(nsTributeChoiceCard, nsAusterityChoiceCard));
        //Also, add sfx and vfx sounds from Buriedbornes
    }
}
