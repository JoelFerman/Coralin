package coral.co.coralin;

/**
 * Created by joelferman on 4/20/16.
 */
public enum  ModelObject
{
    TUTORIAL_1(R.string.tutorial_1, R.layout.view_tutorial_1),
    TUTORIAL_2(R.string.tutorial_2, R.layout.view_tutorial_2),
    TUTORIAL_3(R.string.tutorial_3, R.layout.view_tutorial_3);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
