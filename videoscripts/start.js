import * as mo from "movy"

/**
 * 显示均价动画逻辑
 */
let avgPriceLable;
let avgEqual
let avgPriceValue;
function showAvgPrice() {
    // 显示均价标签
    avgPriceLable = mo.addText("楼盘均价", {
        scale: 0.8,
        color: "yellow"
    });
    avgPriceLable.grow()    
    avgPriceLable.moveTo({
        x: -2.7,
        duration: 1.5
    })
    // 显示=号
    avgEqual = mo.addText("=", {
        scale: 0.7,
        color: "white"
    }).fadeIn({duration: 1.0})    
    // 显示价格
    avgPriceValue = mo.addText("29000", {
        scale: 0.8,
        color: "yellow"
    }).moveTo({
        x: 2.5,
        duration: 0,
    }).fadeIn({duration: 1.5});
}

/**
 * 将均价信息上移
 */
function movingAvgPriceUp() {
    mo.cameraMoveTo({
        y: -2
    });   
}

/**
 * 显示
 */


// 调用函数。出现动画
showAvgPrice();
movingAvgPriceUp();


mo.run();