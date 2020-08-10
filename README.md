# T1 dual screen communication

## Shangmi T1 has two dual screen configurations：

1. The main screen is 14 inches and the secondary screen is 7 inches.


![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/1.png) 


2. The main screen is 14 inches and the secondary screen is 14 inches.

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/2.png) 


The main and secondary screens are all running SUNMIUI system, and T1 dual-screen communication is completed through the interface packaged by Shangmi.

## About the business meter T1 sub screen built-in display program

Usually the developer's business app runs on the main screen, and the secondary screen needs to display list information, promotional pictures, publicity slides, promotional videos and other content. Developers have two ways to display content using the T1 subscreen:

1. Shangmi has a display program built in the T1 sub-screen system (hereinafter referred to as 'sub-display program'). The app of the main screen complies with the unified specifications of Shangmi, and sends data of a specific format to the sub-display program. The program displays the content. (development costs are low, recommended).
2. Developers develop their own screen display app (high development cost, not recommended).

## How to use the Shangmi sub-display program
The quotient specifies the layout that the sub-display program can display. The developer modifies the code of the main screen app and transmits the data of the relevant format to the sub-display program.

The following three paragraphs will explain how to use the sub-display program:
I. Initialize the configuration.
Two. 7-inch screen layout and code passing data.
Three. 14 layouts of the 14-inch screen and code to pass data.

### I. Initial configuration

To operate the 7-inch and 14-inch initialization process, please download the resource file, refer to the Demo project, and directly import the jar package into the main screen app project or declare it in the build.gradle file under the Android Studio app module.

```
dependencies {
    compile 'com.sunmi:DS_Lib:1.0.2'
    compile 'com.google.code.gson:gson:2.6.2'//gson All versions
}
```

Configure the following statement under the <application> node of the manifest file AndroidMainfest.xml:

```
<application>
  ....
          <receiver
              android:name="sunmi.ds.MsgReceiver">
              <intent-filter >
                  <action android:name="com.sunmi.hcservice"></action>
                  <action android:name="com.sunmi.hcservice.status"></action>
              </intent-filter>
          </receiver>
  </application>
  ```
  
  
Initialize the SDK code in the appropriate place as follows, you can refer to the code in the Demo.

``` 
DSKernel mDSKernel =DSKernel.newInstance();
mDSKernel.init(context, mConnCallback);
mDSKernel.addReceiveCallback(mReceiveCallback); 
```

Note: For the interface related to the main and secondary screen communication, please refer to the T1 dual-screen communication interface document in the resource file. The sub-screen guest display operation instruction kit sees the code in Demo:sunmi.ds.data for the operation of the sub-screen display command. The encapsulation is also the APP protocol layer in the framework diagram.

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/3.jpg) 

After completing the above operations, you can send data to the secondary screen. The following explains the display layout of the 7-inch screen and the 14-inch screen and the data format to be transmitted under each layout.

### Two, 7-inch sub-display program can display the following three layouts
1. Full screen display of a single picture
2. Full screen only shows simple text
3. Display image + text in the partial area of the screen

The following explains the data content that the main screen app needs to pass to the sub-display program when the 7-inch screen sub-display program displays each layout:

#### 1. Full screen display of the specified picture on the main screen (7-inch screen)
The effect diagram is as follows:
![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/4.jpg) 

To display the above layout, just call DSKernel's sendFile method to send a picture to the sub-display program. It is recommended that the picture resolution be 1024*600, or the corresponding aspect ratio picture, otherwise it will be zoomed, the picture is instantly displayed in real time, and will be cached and reused. That is to say, theoretically, it is not necessary to use it every time. The program passes the picture.

You can participate in the demo about the 7-inch sub-display related code:

The code when sending data is as follows:

```
String filePath = "xxx/img.png"; // This is the local path of the image to be displayed
 // Send a file to the sub-display program by sending a file to the sendFile of DSKernel
mDSKernel.sendFile(DSKernel.getDSDPackageName(), filePath, new ISendCallback(){
    public void onSendSuccess(long l) {
    // A successful callback is sent. The parameter long l is the unique identifier of the file on the secondary screen. The developer can save the field locally. The next time, the field can be used to query whether the file exists in the secondary display program.
       showImg(fileId);//Send a command to display the picture on the secondary screen
    }
    public void onSendFail(int i, String s) {
    //Send failed callback
    }
    public void onSendProcess(long l, long l1) {
    //Send status callback
    }
});

void showImg(long fileId){
    String json = UPacketFactory.createJson(DataModel.SHOW_IMG_WELCOME, "def");
    mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json, fileId, null);//This command will display the picture on the secondary screen
}
```

Note: In all places where you want to send files (pictures, videos), it is recommended that the developer call DSKernel.checkFileExist(long fileId, final ICheckFileCallback callback) before sending the file to check whether the file has a cache on the secondary screen. If there is any file, then You don't have to repeat it. The code to check is as follows:

```
// Description: This method checks whether the file corresponding to the fileId exists on the secondary screen. The first parameter is the file id returned by the secondary screen when the file is sent before. The id is unique for all files, and the second parameter is the result callback.
mDSKernel.checkFileExist(fileId, new ICheckFileCallback(){
     @Override
     public void onCheckFail() {}
     
     @Override
     public void onResult(boolean arg0) {
        //The return value is true if it exists
        //The return value false does not exist 
         }                                    
    });
```
#### 2. Full screen only displays simple text (7-inch screen)

Display the two lines of characters in the title and content. The layout format is stipulated by the quotient. The main screen app only needs to send the data in the json format to the sub-display program.

The effect chart is as follows:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/5.jpg) 

The code when sending data is as follows：
```
JSONObject json = new JSONObject();
json.put("title", title);//title is the title content of the above line
json.put("content", content);//content is the content of the following line
String jsonStr = json.toString();
//Build the DataPacket class
DataPacket packet = UPacketFactory.buildShowText(
        DSKernel.getDSDPackageName(), jsonStr, callback);//The first parameter is the package name of the secondary display application that receives the data, here you can refer to Demo, the second parameter is the content string to be displayed, and the third parameter is the result callback.

mDSKernel.sendData(packet);//Call the sendData method to send text
```

#### 3. Display picture + text (7-inch screen) in the screen area

The layout format is also stipulated by the quotient. Currently, this layout of the 7-inch screen is recommended to display the following information: the picture is a two-dimensional code, and the text on the right has only two lines of title and content.

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg) 

The data code is as follows:

```
JSONObject json = new JSONObject();
json.put("title", title);//Title is the title content of the above line
json.put("content", content);//Content is the content of the following line
String titleContentJsonStr= json.toString();
 mDSKernel.sendFile(DSKernel.getDSDPackageName(), titleContentJsonStr,filePath, new ISendCallback() {
    @Override
    public void onSendSuccess(long fileId) {
        showQRCode(fileId);//QR code image transmission
    }
    public void onSendFail(int i, String s) {
      //Error callback
    }
    public void onSendProcess(long l, long l1) {
    //Send status callback
    }
});

private void showQRCode(long fileId) {
      String json = UPacketFactory.createJson(sunmi.ds.data.DataModel.QRCODE,"");
      mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json, fileId, null);
```
    
### Three, 14-inch sub-display app can display the following 7 layouts

1. Full screen display only complex table character data
2. The picture is displayed on the left side of the screen and the complex table data is displayed on the right side.
3. The slide is displayed on the left side of the screen and the complex table data is displayed on the right side.
4. The video is displayed on the left side of the screen and the complex table data is displayed on the right side.
5. Display a single picture in full screen
6. Full screen slideshow
7. Full screen video

The following explains the data content that the main screen app needs to pass to the sub-display program when the 14-inch screen sub-display program displays each layout:

#### 1. Full screen only displays complex table character data (14-inch screen)

The table data is displayed in full screen, and the display layout is fixed with three display areas: a title area, a list area, and a settlement area. The title area can only display a string of characters; the list area will display a table, which can display 1 to 8 column fields, the number of lines is not limited, but the line that can be displayed beyond the screen will automatically scroll to the bottom line; the settlement area can be displayed. 1 to 8 fields. The format is fixed by the quotient, but the field title and data content are passed by the main screen app.

The effect chart is as follows:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg) 

code show as below：

```
/**
*receiverPackageName The secondary screen that receives the data shows the app's package name DataType.DATA
*DataType.DATA
*DataModel.TEXT
*jsonStr shows the data content, see the box below for the specific format.
*callback callback
*/
DataPacket pack = buildPack(receiverPackageName, DataType.DATA, DataModel.TEXT, jsonStr, callback);//
mDSKernel.sendData(pack);
```

The data format of jsonStr above is shown in the following box. Please ask the developer to generate data in JSON format by referring to the following format. The title defines the content displayed in the title area, and the head defines the field title in the list area. Please generate the corresponding data according to the reference demo. Please note that the corresponding number of fields conforms to the specification. The key values of the following characters: title, head, list, KVPlist, name, value are fixed words, param1, param2...param8 are sequentially incremented, if the format is incorrect, Unable to display the effect.

```
{
        "title": "三米奶茶店欢迎您", 
        "head": {
            "param1": "序列号",
            "param2": "商品名",
            "param3": "单价"，
            "param4": "数量"，
            "param5": "小结"
        },
        "list": [
            {
              "param1": "1",
              "param2": "华夫饼",
              "param3": "10.00"，
              "param4": "1"，
             "param5":"10.00"
            },
            {
              "param1": "1",
              "param2": "吞拿鱼华夫饼",
              "param3": "12.00"，
              "param4": "1"，
             "param5":"12.00"
            }
            ... ...//Here is the data in the same format
        ],
        "KVPList": [
            {
                "name": "收款",
                "value": "￥40.00"
            },
            {
                "name": "优惠",
                "value": "￥3.00"
            }，
           {
                "name": "找零",
                "value": "￥3.00"
            }，
           {
                "name": "实收",
                "value": "￥37.00"
            }
        ]
}

Data format description:
1: title field is the title
2: the head field is the header field
3: list is the list of products, the number of fields in the header and table should be the same
4: KVPList is a list of settlement key-value pairs

rule:
When only the shopping list is displayed: the number of params assigned to the head is a minimum of 1 and a maximum of 8; the number of params assigned to each element in the list is a minimum of 1 and a maximum of 8; the size of the KVPList is a minimum of 1 and a maximum of 8.

```

#### 2. The picture on the left of the screen is displayed, and the complex table data is displayed on the right (14-inch screen)

The left area shows the picture, the recommended picture size is 1186*1080; the right area shows complex table data, which is also divided into three display areas: title area, list area, and settlement area. The title area can only display a string of characters; the list area will display a table with up to 4 columns of fields, and the line data beyond the screen range can be scrolled; the settlement area can display 1 to 4 fields.

Effect chart:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg) 

code show as below:

```
String filePath = "xxx/img.png";//Displayed image path
mDSKernel.sendFile(DSKernel.getDSDPackageName(), filePath, new ISendCallback() {
    public void onSendSuccess(long fileId) {
        show(fileId, jsonStr);//The picture is sent successfully and the text content is displayed
    } 
    public void onSendFail(int errorId, String errorInfo) {}
    public void onSendProcess(long total, long sended) {}
});

void show(long fileId, String jsonStr){
    jsonStr = UPacketFactory.createJson(DataModel.SHOW_IMG_LIST, jsonStr);//The first parameter DataModel.SHOW_IMG_LIST is the display layout mode, jsonStr is the content character to be displayed
    mDSKernel.sendCMD(DSKernel.getDSDPackageName(), jsonStr, fileId,null);
}

```

The data format of jsonStr above is shown in the following box. Please ask the developer to generate data in JSON format by referring to the following format. The title defines the content displayed in the title area, and the head defines the field title in the list area. Please generate the corresponding data according to the reference Demo. Please note that the corresponding number of fields conforms to the specification. The key values of the following characters: title, head, list, KVPlist, name, and value are fixed words, and param1, param2...param4 are sequentially incremented.

```
{
        "title": "商米奶茶店欢迎你",
        "head": {
          "param1": "商品名",
            "param2": "单价"，
            "param3": "数量"，
           "param4":"小结"
        },
        "list": [
            {
           
              "param1": "华夫饼",
              "param2": "10.00"，
              "param3": "1"，
             "param4":"10.00"
            },
            {
            
              "param1": "吞拿鱼华夫饼",
              "param2": "12.00"，
              "param3": "1"，
             "param4":"12.00"
            }
            ... ...
        ],
        "KVPList": [
            {
                "name": "收款",
                "value": "￥40.00"
            },
            {
                "name": "优惠",
                "value": "￥3.00"
            }，
           {
                "name": "找零",
                "value": "￥3.00"
            }，
           {
                "name": "实收",
                "value": "￥37.00"
            }
        ]
}

JSON data format description:
1: title field is the title
2: the head field is the header field
3: list is the list of products, the number of fields in the header and table should be the same
4: KVPList is a list of settlement key-value pairs

rule:
When displaying the picture and text mixture: the number of params assigned to the head is at least 1 and the maximum is 4; the number of params assigned to each element in the list is at least 1 and the maximum is 4; the size of the KVPList is at least 1 and the maximum is 4.

```

#### 3. The slide is displayed on the left side of the screen, and the complex table data is displayed on the right side (14-inch screen)

The left area shows the slideshow. The recommended image size is 1186*1080. The right area shows complex table data, which is also divided into three display areas: title area, list area, and settlement area. The title area can only display a string of characters; the list area will display a table with up to 4 columns of fields, and the line data beyond the screen range can be scrolled; the settlement area can display 1 to 4 fields.


Effect chart:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg) 

code show as below：

```
List<String> paths = new ArrayList<>();
paths.add(Environment.getExternalStorageDirectory().getPath() + "/sunmi1.png");
paths.add(Environment.getExternalStorageDirectory().getPath() + "/sunmi2.png");
paths.add(Environment.getExternalStorageDirectory().getPath() + "/sunmi3.png");
paths.add(Environment.getExternalStorageDirectory().getPath() + "/sunmi4.png");

mDSKernel.sendFiles(DSKernel.getDSDPackageName(), "", paths, new ISendFilesCallback() {
    @Override
    public void onAllSendSuccess(long fileId) {               
      sendImgsListCMD(fileId,json);                           
    }

    @Override
    public void onSendSuccess(String path, long taskId) {}
    @Override
    public void onSendFaile(int errorId, String errorInfo) {}
    @Override
    public void onSendFileFaile(String path, int errorId, String errorInfo) {}
    @Override
    public void onSendProcess(String path, long totle, long sended) {}
    });
    
    void sendImgsListCMD(long fileId, String jsonStr){   
      jsonStr= UPacketFactory.createJson(DataModel.SHOW_IMGS_LIST, json);
        mDSKernel.sendCMD(DSKernel.getDSDPackageName(), jsonStr, fileId,null);
    }
```
The data format rules of jsonStr above are the same as those in layout 2, and will not be described here.

#### 4. The video is displayed on the left side of the screen, and the complex table data is displayed on the right side.


The left area shows the video, the recommended resolution is 1186*1080; the right area shows complex table data, which is also divided into three display areas: title area, list area, and settlement area. The title area can only display a string of characters; the list area will display a table with up to 4 columns of fields, and the line data beyond the screen range can be scrolled; the settlement area can display 1 to 4 fields.

Effect chart:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg)

```
String filePath = "xxx/video.mp4";//Displayed video path
mDSKernel.sendFile(DSKernel.getDSDPackageName(), filePath, new ISendCallback() {
    public void onSendSuccess(long fileId) {
        show(fileId, jsonStr);//Video sent successfully
    } 
    public void onSendFail(int errorId, String errorInfo) {}
    public void onSendProcess(long total, long sended) {}
});

void show(long fileId, String jsonStr){
    jsonStr = UPacketFactory.createJson(DataModel.SHOW_VIDEO_LIST, jsonStr);
    mDSKernel.sendCMD(DSKernel.getDSDPackageName(), jsonStr, fileId,null);
}
```

The data format rules of jsonStr above are the same as those in layout 2, and will not be described here.
#### 5. Full-screen display of a single picture (14-inch screen)

Effect chart:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg)

Similar to the 7-inch screen, the picture is sent first. After the transmission is successful, the control command is displayed in the callback to display the picture. The code is as follows:

```
String filePath = "/sdcard/img.png";
mDSKernel.sendFile(DSKernel.getDSDPackageName(), filePath, new ISendCallback(){
    public void onSendSuccess(long l) {
       showImg(fileId);//Send picture first
    }
    public void onSendFail(int i, String s) {}
    public void onSendProcess(long l, long l1) {}
});

void showImg(long fileId){
    String json = UPacketFactory.createJson(DataModel.SHOW_IMG_WELCOME, "def");
    mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json, fileId, null);
}
```

#### 6. Full screen display video (14 inch screen)

Effect chart:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg)


When the video is displayed for the first time, the process of passing the video may be very long. The developer should first pass the video to the sub-display program at the appropriate time. The sub-display program will cache the video. The code is as follows:

```
String filePath = "/sdcard/onepiece.mp4";
mDSKernel.sendFile(DSKernel.getDSDPackageName(), filePath, new ISendCallback(){
    public void onSendSuccess(long l) {
       playVideo(fileId);
    }
    public void onSendFail(int errorId, String errorInfo) {}
    public void onSendProcess(long total, long sended) {}
});

void playVideo(long fileId){
    String json = UPacketFactory.createJson(DataModel.VIDEO, "");
    mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json, fileId, null);
}
```
    
#### 7. Full screen display slideshow (14-inch screen)

The effect chart is as follows:

![Alt SUNMI](https://github.com/VNAPNIC/sample-sunmi-d2/blob/master/image/7.jpg)


The developer needs to prepare multiple images, call the sendFiles method to pass the path of multiple images to the sub-display program. The default switching time of the slide is 10 seconds. The main screen app can change the time by passing parameters. For details, please refer to the following code.

```
JSONObject json = new JSONObject();
json.put("interval",5000); //The switching time of the slide show, calculated in milliseconds, if not passed, the default is 10000 millisecond
List<String> pathList = new ArrayList<>();
pathList.add("/sdcard/img1.png");
pathList.add("/sdcard/img2.png");
...
mDSKernel.sendFiles(DSKernel.getDSDPackageName(), json.toString(), pathList, new ISendFilesCallback() {
    public void onAllSendSuccess(long fileId) {
        show(fileId);
    }
    public void onSendSuccess(final String s,final long l) {}
    public void onSendFaile(int errorId, String errorInfo) {}
    public void onSendFileFaile(String path, int errorId, String errorInfo){}
    public void onSendProcess(String path, long total, long sended) {}
});

private void show(long fileId) {
    String json = UPacketFactory.createJson(DataModel.IMAGES,"");
    mDSKernel.sendCMD(DSKernel.getDSDPackageName(),json,fileId,null);
}
```

Additional instructions:
The above is the layout currently supported by the Sunmi T1 built-in display program. More layouts will be added later, and developers can also develop sub-display programs that adapt to the merchant T1.
