package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ThrowSoulstones extends AbstractPackmasterCard {

    public final static String ID = makeID("ThrowSoulstones");

    public ThrowSoulstones(){
        super(ID, 0, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 5;
        baseMagicNumber = 15;
    }

    @Override
    public void upp() {
        magicNumber += 5;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        //Austerity: Deal 5 damage. Tribute 10: deal 15 damage AND play this card again.
    }
}
