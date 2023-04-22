package thePackmaster.cards.summonerspellspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.powers.summonerspellspack.SnowballStrikePower;

public class SnowballStrike extends AbstractSummonerSpellsCard {
    public static final String ID = SpireAnniversary5Mod.makeID("SnowballStrike");
    private static final int COST = 1;
    private static final int DAMAGE = 8;
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;


    public SnowballStrike() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.tags.add(CardTags.STRIKE);
        this.damage = this.baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = MAGIC;
        cardsToPreview = new DashSlap();
    }

    @Override
    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        addToBot(new ApplyPowerAction(p, p, new SnowballStrikePower(p, magicNumber), magicNumber));
    }
}
