package newutil;

import org.hibernate.boot.model.naming.EntityNaming;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl;

import java.util.Locale;

public class SampleEntity_MyImplicitNamingStrategy extends ImplicitNamingStrategyLegacyHbmImpl {

    @Override
    public String transformEntityName(EntityNaming entityNaming) {
        return applyToEntityName(entityNaming.getEntityName());
    }

    @Override
    public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
        return source.isCollectionElement() ? this.toIdentifier("elt", source.getBuildingContext()) : apply(super.determineBasicColumnName(source));

   }


    private String applyToEntityName(String name) {
        if (name == null) {
            return null;
        } else {
//            StringBuilder text = new StringBuilder(name.replace('.', '_'));
            StringBuilder text = new StringBuilder(name);
            insert_underscore(text);
            return text.toString().toLowerCase(Locale.ROOT);
        }
    }

    private Identifier apply(Identifier name) {
        if (name == null) {
            return null;
        } else {
            StringBuilder text = new StringBuilder(name.getText());
            insert_underscore(text);
            return new Identifier(text.toString().toLowerCase(Locale.ROOT), name.isQuoted());
        }
    }

    private void insert_underscore(StringBuilder text) {
        for(int i = 1; i < text.length() - 1; ++i) {
            if (this.isUnderscoreRequired(text.charAt(i - 1), text.charAt(i), text.charAt(i + 1))) {
                text.insert(i++, '_');
            }
        }
    }

    private boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isLowerCase(before) && Character.isUpperCase(current) && Character.isLowerCase(after);
    }


}