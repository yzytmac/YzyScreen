# ScreenAdaptive
最屌的屏幕适配框架-100%适配所有屏幕  
原理：控件像素 =（ui像素/ui屏幕像素）* 手机屏幕像素；手机屏幕像素是从每部手机动态获取的，所以能为任何手机适配，也不需要转化成dp来适配。  
使用步骤：  
1、在gradle中依赖compile 'com.github.yzytmac:yzyscreenadaptive:1.0.0'  
2、在java代码中拿到控件  
3、ViewUtil.getInstance(this,baseWidth,baseHeight).setLayoutParams(mTv,widthPx,heightPx,0,0,0,0);  
baseWidth和baseHeight是美工ui图的基准宽高，即美工是在什么分辨率的屏幕上标注的  
widthPx和heightPx就是控件标注的像素值，因为美工给的都是像素，最后4个0是margin值  
这样我们在布局文件中只需要关心控件的位置，具体的宽高就在代码中这样设置即可  
4、如果布局复杂或对性能有要求，那么就用框架中的百分比相对布局PercentRelativeLayout来代替原来的布局。  
控件中加入app:layout_percent_height="0.5"和app:layout_percent_width="0.5"属性即可设置控件在布局中的百分比。  
此时xml文件中的控件宽高只能设置成wrap_content或match_parent，设置成具体值将会导致百分比无效。  
5、执行优先级从高到低为：setLayoutParams——>具体宽高——>百分比
