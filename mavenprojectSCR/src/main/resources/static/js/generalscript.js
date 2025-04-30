var textElements = document.getElemensByTagName('input');
for (var element in textElements)
{
    if (element.type == "text")
    {
        element.setAttribute("maxlength", 50);
    }
}
