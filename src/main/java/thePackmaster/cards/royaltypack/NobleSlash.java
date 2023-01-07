package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class NobleSlash extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleSlash");

    public NobleSlash(){
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 12;
    }

    @Override
    public void upp() {
        baseDamage += 6;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        //Apply debuff on player to discard card at the start of the next turn
        dmg(abstractMonster, AbstractGameAction.AttackEffect.SLASH_HEAVY);
    }
}
