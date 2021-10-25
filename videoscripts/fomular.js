import * as mo from "movy"

// 显示均价
const label = mo.addText("楼盘均价", {
    scale: 0.5,
    color: "yellow",
});
label.moveTo({
    y: -0.8,
    duration: 1.5,
});
mo.addLine({
    from: {
        x: -1.5
    },
    to: {
        x: 1.5,
    },
    color: "yellow"
}).fadeIn({ duration: 0.5 });
const price = mo.addText("29000", {
    scale: 0.6,
    color: "yellow",
    y: 0.8
}).fadeIn({ duration: 3.0 });
// 向左移动
mo.cameraMoveTo({
    x: 3,
    duration: 1.5
});
// 显示乘号
mo.addText(" X ", {
    x: 3,
    scale: 0.6,
    color: "yellow",
}).grow();
// 刚需面积 
const label2 = mo.addText("刚需面积", {
    x: 6,
    scale: 0.5,
    color: "yellow"
}).grow();
label2.moveTo({
    y: -0.8,
    duration: 1.0
});
mo.addLine({
    from: {
        x: 4.5
    },
    to: {
        x: 7.5,
    },
    color: "yellow"
}).fadeIn({ duration: 0.5 });
mo.addText("90平方", {
    x: 6,
    y: 0.8,
    scale: 0.5,
    color: "yellow"
}).grow();
// 移动camera
mo.cameraMoveTo({
    x: 6,
    duration: 1.5,
});
// 显示乘号
mo.addText(" X ", {
    x: 9,
    scale: 0.6,
    color: "yellow",
}).grow();
// 显示首付比例
const label3 = mo.addText("首付比例", {
    x: 12,
    scale: 0.5,
    color: "yellow"
}).grow();
label3.moveTo({
    y: -0.8,
    duration: 1.0
});
mo.addLine({
    from: {
        x: 10.5
    },
    to: {
        x: 13.5,
    },
    color: "yellow"
}).fadeIn({ duration: 0.5 });
mo.addText("30%", {
    x: 12,
    y: 0.8,
    scale: 0.5,
    color: "yellow"
}).grow();
// 隐藏所有
mo.fadeOutAll({ duration: 2.0 });
// 显示总价
const allPrice = mo.addText("78.3万", {
    x: 6,
    y: 0.8,
    scale: 0.8,
    color: "yellow",
}).grow();
mo.addLine({
    from: {
        x: 4.5
    },
    to: {
        x: 7.5
    },
    color: "yellow",
}).grow();
mo.addText("首付款", {
    x: 6,
    y: -0.8,
    scale: 0.6,
    color: "yellow",
}).grow();
// 移动摄像头
mo.cameraMoveTo({
    x: 9,
    duration: 1.5
});
// 除号
mo.addText(" % ", {
    x: 9,
    scale: 0.8,
    color: "yellow"
}).grow();
// 年收入
const yearIncome = mo.addText("年收入", {
    x: 12,
    scale: 0.6,
    color: "yellow"
}).grow();
yearIncome.moveTo({
    y: -0.8
});
mo.addLine({
    from: {
        x: 10.5
    },
    to: {
        x: 13.5
    },
    color: "yellow",
}).grow();
mo.addText("24万", {
    x: 12,
    y: 0.8,
    scale: 0.8,
    color: "yellow",
}).grow();

mo.fadeOutAll({duration: 2.0})

// 时间
mo.addText("3.26年!", {
    x: 9,
    scale: 0.9,
    color: "orange"
}).grow().shake2D({duration: 0.5});

mo.run();