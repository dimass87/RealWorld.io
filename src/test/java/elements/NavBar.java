package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(tagName = "nav")
public class NavBar extends HtmlElement {

    @FindBy(css = ".navbar-brand.ng-binding")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(normalize-space(text()), 'Home') and ancestor::ul[@show-authed='false']]")
    private WebElement homeLink;

    @FindBy(xpath = "//a[contains(normalize-space(text()), 'Sign in') and ancestor::ul[@show-authed='false']]")
    private WebElement SignInLink;

    @FindBy(xpath = "//a[contains(normalize-space(text()), 'Sign up') and ancestor::ul[@show-authed='false']]")
    private WebElement SignUpLink;
}
