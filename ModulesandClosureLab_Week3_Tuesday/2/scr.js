
window.onload = init;
function init(){
    document.getElementById("add").onclick = addAccount;
}

var accounts;

var account = {
    accountName:"", deposit:0,
    toStr: function(){
        return "Account name: " + this.accountName + ": " + this.deposit;
    }
};
var accountAdd = (function () {
    return {
        addNewAccount: function (name, depo) {
            let acc = Object.create(account);
            acc.accountName = name;
            acc.deposit = depo;
            if (accounts == null)
                accounts = [acc];
            else
                accounts[accounts.length] = acc;
        },
        updateText: function () {
            var text = "";
            for (var i = 0; i < accounts.length; i++) {
                if (text != "")
                    text += "\n";
                text += accounts[i].toStr();
            }
            document.getElementById("text").value = text;
        }
    }
})();
function addAccount(){
    let name = document.getElementById("name").value;
    let dep = document.getElementById("depo").value;
    accountAdd.addNewAccount(name, dep);
    accountAdd.updateText();
};